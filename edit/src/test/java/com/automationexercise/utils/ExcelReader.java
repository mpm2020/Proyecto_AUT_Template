package com.automationexercise.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    
    /**
     * Lee datos del archivo Excel y los retorna como arreglo de objetos
     * @param rutaExcel Ruta del archivo Excel
     * @param nombreSheet Nombre de la hoja a leer
     * @return Matriz de objetos con los datos del Excel
     * @throws IOException Si hay error al leer el archivo
     */
    public static Object[][] leerExcel(String rutaExcel, String nombreSheet) throws IOException {
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(new File(rutaExcel));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(nombreSheet);
            if (sheet == null) {
                throw new IllegalArgumentException("La hoja '" + nombreSheet + "' no existe en el archivo: " + rutaExcel);
            }

            Row header = sheet.getRow(0);
            if (header == null) {
                throw new IllegalArgumentException("El archivo Excel está vacío o no tiene cabecera: " + rutaExcel);
            }

            int filas = Math.max(0, sheet.getPhysicalNumberOfRows() - 1);
            int columnas = header.getPhysicalNumberOfCells();
            Object[][] datos = new Object[filas][columnas];

            int dataIndex = 0;
            for (int i = 1; i <= filas; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < columnas; j++) {
                        if (row.getCell(j) != null) {
                            datos[dataIndex][j] = formatter.formatCellValue(row.getCell(j));
                        } else {
                            datos[dataIndex][j] = "";
                        }
                    }
                    dataIndex++;
                }
            }

            return datos;
        }
    }
}
