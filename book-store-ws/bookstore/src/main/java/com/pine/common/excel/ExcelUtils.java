package com.pine.common.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.pine.common.date.DateConstants;
import com.pine.common.io.FileUtil;
import com.pine.common.io.LoggerUtil;
import com.pine.common.lang.ObjectUtility;
import com.pine.common.lang.StringUtil;

public class ExcelUtils {

	public static final String DEFAULT_WORK_SHEET_NAME = "REPORTS";
	public static final String DEFAULT_FONT_FACE = "VERDANA";

	private static Map<Sheet, HSSFPatriarch> drawingPatriarches = new HashMap<Sheet, HSSFPatriarch>();

	public static HSSFWorkbook write(List<List<String>> listOfList, String workSheetName) {

		if (StringUtil.isBlank(workSheetName)) {
			workSheetName = DEFAULT_WORK_SHEET_NAME;
		}
		int lengthOfColumns = ((List<String>) listOfList.get(0)).size();

		// Do the POI Things to generate the Excel File create a new workbook
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet(workSheetName);

		/*******************************************
		 * This Part Contains The Cell Formatting Stuff.
		 ********************************************/
		// Create a Font For Header
		HSSFFont headerFont = workBook.createFont();
		headerFont.setBold(true);
		headerFont.setFontName(DEFAULT_FONT_FACE);

		// create a style for the header Columns
		HSSFCellStyle columnHeaderStyle = workBook.createCellStyle();
		// columnHeaderStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); //
		// Call This method before calling below one.
		// columnHeaderStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
		columnHeaderStyle.setFont(headerFont);

		// Create a Font For Data Rows
		HSSFFont rowFont = workBook.createFont();
		rowFont.setFontName(DEFAULT_FONT_FACE);

		// create a style for the Records In Next Rows
		HSSFCellStyle rowCellStyle = workBook.createCellStyle();
		rowCellStyle.setFont(rowFont);
		/**********************************************/

		HSSFRow[] headerRow = new HSSFRow[listOfList.size()];
		ListIterator<List<String>> outerListIterator = listOfList.listIterator();

		// Create Header Row
		if (outerListIterator.hasNext()) {

			int rowIndex = outerListIterator.nextIndex();
			List<String> innerList = (List<String>) outerListIterator.next();

			// create header rows: Write the column header in Very First(0th)
			// Row Of Excel File
			headerRow[rowIndex] = sheet.createRow((short) rowIndex);
			HSSFCell[] headerColumns = new HSSFCell[lengthOfColumns]; // Create
																		// Data
																		// for
																		// the
																		// Header
																		// Row

			ListIterator<String> innerListIterator = innerList.listIterator();
			while (innerListIterator.hasNext()) {
				int columnIndex = innerListIterator.nextIndex();
				headerColumns[columnIndex] = headerRow[rowIndex].createCell((short) columnIndex);

				String cellValue = innerListIterator.next();
				headerColumns[columnIndex].setCellValue(cellValue);
				headerColumns[columnIndex].setCellStyle(columnHeaderStyle);
			}
		}
		// Create other Row(s)
		while (outerListIterator.hasNext()) {

			int rowIndex = outerListIterator.nextIndex();
			List<String> innerList = (List<String>) outerListIterator.next();

			headerRow[rowIndex] = sheet.createRow((short) rowIndex);
			HSSFCell[] headerColumns = new HSSFCell[lengthOfColumns]; // Create
																		// Data
																		// for
																		// the
																		// Header
																		// Row

			ListIterator<String> innerListIterator = innerList.listIterator();
			while (innerListIterator.hasNext()) {
				int columnIndex = innerListIterator.nextIndex();
				headerColumns[columnIndex] = headerRow[rowIndex].createCell((short) columnIndex);

				String cellValue = innerListIterator.next();
				headerColumns[columnIndex].setCellValue(cellValue);
				headerColumns[columnIndex].setCellStyle(rowCellStyle);
			}
		}
		return workBook;
	}

	public static void addComment(Cell cell, String commentText) throws Exception {
		if (getComment(cell) != null && StringUtils.isNotBlank(getComment(cell))) {
			commentText = getComment(cell) + "\n" + commentText;
		}
		setComment(cell, commentText);
	}

	public static void autoColumn(Sheet sheet) throws Exception {
		for (int i = 0; i < getMaxColnum(sheet) - 1; i++) {
			LoggerUtil.debug("## " + i);

			sheet.autoSizeColumn(i);
		}
	}

	public static Cell createCell(Sheet sheet, int rownum, int column) throws Exception {
		Cell cell = null;
		Row row = sheet.getRow(rownum);
		if (row == null) {
			row = sheet.createRow(rownum);
		}
		cell = row.getCell(column);
		if (cell == null) {
			cell = row.createCell(column);
		}
		return cell;
	}

	public static Cell getCell(Workbook wb, int rownum, int colnum) {
		Cell cell = null;
		try {
			cell = wb.getSheetAt(0).getRow(rownum).getCell(colnum);
		} catch (Exception e) {
			cell = null;
		}
		return cell;
	}

	public static String getComment(Cell cell) {
		String commentString = null;
		try {
			commentString = cell.getCellComment().getString().getString();
		} catch (Exception e) {
			commentString = null;
		}
		return commentString;
	}

	public static String getCommentAuthor(Cell cell) throws Exception {
		String commentString = null;
		commentString = cell.getCellComment().getAuthor();
		return commentString;
	}

	public static CreationHelper getCreationHelper(Cell cell) throws Exception {
		CreationHelper creationHelper = null;
		creationHelper = cell.getSheet().getWorkbook().getCreationHelper();
		return creationHelper;

	}

	public static int getMaxColnum(Sheet sheet) {
		int maxColnum = -1;
		try {
			for (Row row : sheet) {
				if (maxColnum < row.getLastCellNum()) {
					maxColnum = row.getLastCellNum();
				}
			}
		} catch (Exception e) {
			maxColnum = -1;
		}
		return maxColnum + 1;

	}

	public static int getMaxColnum(String fileName) throws Exception {
		return getMaxColnum(getWorkBook(fileName).getSheetAt(0));
	}

	public static int getMaxRownum(String fileName) {
		int maxRownum = 0;
		try {
			maxRownum = getWorkBook(fileName).getSheetAt(0).getLastRowNum() + 1;
		} catch (Exception e) {
			maxRownum = 0;
		}

		return maxRownum;
	}

	public static String getString(Cell cell) {
		String value = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				value = cell.getRichStringCellValue().getString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = String.valueOf(DateConstants.FMT_YYYY_MM_DD.format(cell.getDateCellValue()));
				} else {
					// determine it's a currency format or percentage
					CellStyle cs = cell.getCellStyle();
					String format = cs.getDataFormatString();
					DecimalFormat pf = null;
					if (format != null) {
						if (format.contains("%")) {
							pf = new DecimalFormat("0.0###########%");
							pf.setParseBigDecimal(true);
							pf.setMultiplier(100);
						} else if (format.contains(",")) {
							pf = new DecimalFormat("#,##0.00");
							pf.setParseBigDecimal(true);
						} else {
							pf = new DecimalFormat("0");
						}
					}

					double dValue = cell.getNumericCellValue();
					if (pf != null) {
						value = pf.format(dValue);
					}

				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				value = cell.getCellFormula();
				break;
			default:
				value = null;
			}
			if (value != null) {
				value = value.trim();
			}
		}
		return value;

	}

	public static Workbook getWorkBook(String fileName) throws Exception {
		Workbook wb = null;
		wb = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(new File(fileName))));
		return wb;

	}

	public static Map<Integer, Cell> readExcelByColumn(String fileName, int colnum) throws Exception {
		Workbook wb = getWorkBook(fileName);
		return readExcelByColumn(wb, colnum);
	}

	public static Map<Integer, Cell> readExcelByColumn(Workbook wb, int colnum) {
		Map<Integer, Cell> cellMap = new TreeMap<Integer, Cell>();
		Sheet sheet = wb.getSheetAt(0);

		if (sheet.getRow(2) != null && sheet.getRow(2).getLastCellNum() >= colnum) {
			int rownum = 1;
			for (Row row : sheet) {
				try {
					if (row.getCell(colnum) != null) {
						cellMap.put(rownum, row.getCell(colnum));
					}
				} catch (Exception e) {
					// skip intentionally
				}
				rownum++;
			}
		}
		return cellMap;
	}

	public static List<String> readExcelByRow(Workbook wb, int rownum) {
		List<String> result = new ArrayList<String>();
		Sheet sheet = wb.getSheetAt(0);

		int rowNumber = 0;
		for (Row row : sheet) {
			if (rownum == rowNumber) {
				for (Cell cell : row) {
					result.add(getString(cell));
				}
				break;
			}
			rowNumber++;
		}
		return result;
	}

	public static void setBackgroundColor(Cell cell, short colorIndex) {

		if (cell != null) {
			if (cell.getCellStyle() == null) {
				cell.setCellStyle(cell.getSheet().getWorkbook().createCellStyle());
			}
			cell.getCellStyle().setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			cell.getCellStyle().setFillForegroundColor(colorIndex);
		}

	}

	public static Cell setCell(Sheet sheet, int rownum, int column, Date value, Cell sampleCell) throws Exception {

		Cell cell = createCell(sheet, rownum, column);
		if (cell != null) {
			if (value != null) {
				cell.setCellValue(value);
			}
			setCellStyles(cell, sampleCell);
			// cell.getCellStyle().setDataFormat(getCreationHelper(cell).createDataFormat().getFormat("yyyy-mm-dd"));

			sheet.autoSizeColumn((short) column);
		}

		return cell;
	}

	public static Cell setCell(Sheet sheet, int rownum, int column, double value, Cell sampleCell) throws Exception {

		Cell cell = createCell(sheet, rownum, column);
		LoggerUtil.debug("(" + rownum + "," + column + "):" + value);
		if (cell != null) {
			cell.setCellValue(value);
			setCellStyles(cell, sampleCell);
			sheet.autoSizeColumn((short) column);
		}
		return cell;
	}

	public static Cell setCell(Sheet sheet, int rownum, int column, String value, Cell sampleCell) throws Exception {

		Cell cell = createCell(sheet, rownum, column);
		if (cell != null) {
			LoggerUtil.info("setCell():value=" + value);
			if (value != null) {
				cell.setCellValue(value);
			}
			setCellStyles(cell, sampleCell);
			sheet.autoSizeColumn((short) column);
		}
		return cell;
	}

	/**
	 * copy all cell style from sourceCell to desCell, including comments
	 * 
	 * @param desCell
	 * @param sourceCell
	 */
	public static void setCellStyles(Cell desCell, Cell sourceCell) {
		setCellStyles(desCell, sourceCell, false);
	}

	public static void setCellStyles(Cell desCell, Cell sourceCell, boolean copyComment) {
		try {
			if (desCell != null && sourceCell != null) {
				CellStyle theCellStyle = desCell.getSheet().getWorkbook().createCellStyle();
				Font theFont = desCell.getSheet().getWorkbook().createFont();

				ObjectUtility.copyAttributes(sourceCell.getCellStyle(), theCellStyle);
				ObjectUtility.copyAttributes(
						sourceCell.getSheet().getWorkbook().getFontAt(sourceCell.getCellStyle().getFontIndex()),
						theFont);
				theCellStyle.setFont(theFont);

				LoggerUtil.debug("### format=" + sourceCell.getCellStyle().getDataFormatString());
				theCellStyle.setDataFormat(getCreationHelper(desCell).createDataFormat()
						.getFormat(sourceCell.getCellStyle().getDataFormatString()));

				desCell.setCellStyle(theCellStyle);

				if (copyComment && getComment(sourceCell) != null) {
					// addComment(desCell, getComment(sourceCell));
					setComment(desCell, getComment(sourceCell));
				}
			}
		} catch (Exception e) {
			// ignore on purpose because not guaranteed successful and it's
			// reasonable
		}
	}

	public static void setComment(Cell cell, String text) {
		CreationHelper createHelper = cell.getSheet().getWorkbook().getCreationHelper();
		HSSFSheet sheet = (HSSFSheet) cell.getSheet();
		if (drawingPatriarches == null) {
			drawingPatriarches = new HashMap<Sheet, HSSFPatriarch>();
		}
		HSSFPatriarch drawingPatriarch = drawingPatriarches.get(sheet);
		if (drawingPatriarch == null) {
			drawingPatriarch = sheet.createDrawingPatriarch();
			drawingPatriarches.put(sheet, drawingPatriarch);
		}

		int height = StringUtils.countMatches(text, "\n");
		int width = 0;
		for (String oneLine : StringUtils.split(text, "\n")) {
			if (oneLine != null && width < oneLine.length()) {
				width = oneLine.length();
			}
		}
		width = (short) (1 + (width / 16));
		height = 2 + height;

		Comment comment = drawingPatriarch
				.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 0, 0, (short) width, height));
		comment.setString(createHelper.createRichTextString(text));
		cell.setCellComment(comment);
	}

	public static void setFontColor(Cell cell, short colorIndex) {
		if (cell != null) {
			HSSFFont font = ((HSSFWorkbook) cell.getSheet().getWorkbook()).createFont();
			font.setColor(HSSFColor.RED.index);
			cell.getCellStyle().setFont(font);
		}

	}

	public static File workbookToFile(Workbook wb, String fileName)
			throws IOException, FileNotFoundException, Exception {
		FileOutputStream fileOut;
		File excelFile = new File(fileName);
		if (wb != null) {
			try {
				fileOut = new FileOutputStream(excelFile);
				wb.write(fileOut);
				fileOut.close();
			} catch (FileNotFoundException e) {
				throw e;
			} catch (IOException e) {
				throw e;
			} finally {
				if (drawingPatriarches != null && drawingPatriarches.get(wb.getSheetAt(0)) != null) {
					drawingPatriarches.remove(wb.getSheetAt(0));
				}
			}
		}
		return excelFile;
	}

	public static String workbookToHtml(String fileName) throws Exception {
		String result = null;
		Map<String, Object> reportRoot = new HashMap<String, Object>();
		// Processor processor = new Processor();

		try {
			Workbook wb = getWorkBook(fileName);

			reportRoot.put("clientName", getString(getCell(wb, 0, 0)));
			reportRoot.put("invoiceDate", getString(getCell(wb, 1, 0)));

			List<String> allS = new ArrayList<String>();
			for (int i = 1; i < getMaxColnum(wb.getSheetAt(0)); i++) {
				allS.add("nbsp;");
			}
			reportRoot.put("allS", allS);

			List<String> notes = readExcelByRow(wb, 12);
			List<String> warns = readExcelByRow(wb, 13);
			List<String> errors = readExcelByRow(wb, 14);
			List<String> successes = readExcelByRow(wb, 15);

			reportRoot.put("notes", notes);
			reportRoot.put("warns", warns);
			reportRoot.put("errors", errors);
			reportRoot.put("successes", successes);

			reportRoot.put("fileName", fileName);

			Map<String, List<List<String>>> rows = new TreeMap<String, List<List<String>>>();
			reportRoot.put("rows", rows);

			List<List<String>> group1 = new ArrayList<List<String>>();
			rows.put("Fee Calculation", group1);
			for (int i = 4; i < 12; i++) {
				group1.add(readExcelByRow(wb, i));
			}

			List<List<String>> group2 = new ArrayList<List<String>>();
			rows.put("Inputs", group2);
			for (int i = 18; i < 31; i++) {
				group2.add(readExcelByRow(wb, i));
			}

			List<List<String>> group3 = new ArrayList<List<String>>();
			rows.put("Management Fee Static Datan", group3);
			for (int i = 33; i < 40; i++) {
				group3.add(readExcelByRow(wb, i));
			}

			List<List<String>> group4 = new ArrayList<List<String>>();
			rows.put("Performance Fee Static Data", group4);
			for (int i = 42; i < 49; i++) {
				group4.add(readExcelByRow(wb, i));
			}

		} catch (Exception e) {
			LoggerUtil.warn("Error", e);
			result = "";
			return result;
		}

		return result;
	}

	public void createExcelFile(String fileName) throws IOException {
		Workbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream(fileName);
		wb.write(fileOut);
		FileUtil.closeQueitly(wb);
	}

	public static String excelToHtml(String excelFileName, String csvFileName, String ntasFileName) throws Exception {
		String result = "";
		Workbook wb = getWorkBook(excelFileName);
		// TODO
		return result;
	}

	public static void main(String[] args) {
		try {
			String html = excelToHtml("C:\\calculator\\bugs\\CalResult101231120000_1059.xls", "", "");
			System.out.println(html);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
