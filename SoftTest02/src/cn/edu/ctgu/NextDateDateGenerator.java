package cn.edu.ctgu;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class NextDateDateGenerator {
	private final static String destDir = "test/resources/";

	public static void main(String[] args) throws Exception {
		// 生成一般边界值测试数据
		test1NormalBoundaryValue();

		// 生成最坏情况边界测试数据
		test2WorstBoundaryValue();

		// 生成健壮边界值测试数据
		test3RobustBoundaryValue();

		// 生成健壮最坏情况测试用例
		test4RobustWorstBoundaryValue();

	}
	
	// 一般边界值测试: 4n+1
		public static void test1NormalBoundaryValue() throws Exception {
			// TODO Auto-generated method stub
			int[] day = { 1, 2, 15, 30, 31 };
			int[] month = { 1, 2, 6, 11, 12 };
			int[] year = { 1900, 1901, 1975, 2049, 2050 };
			FileOutputStream fos = new FileOutputStream(destDir + "NextDate一般边界测试用例.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "day", "month", "year", "期望值");
			CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

			int num = 0;
			for (int a : day) {
				for (int b : month) {
					for (int c : year) {
						if (a == 15 && b == 6 || a == 15 & c == 1975 || b == 6 && c == 1975) {
							csvPrinter.printRecord(++num, a, b, c, NextDate.getDate(a, b, c));
						}
					}
				}
			}
			csvPrinter.flush();
			csvPrinter.close();
		}

		// 最坏情况测试: 5^n
		public static void test2WorstBoundaryValue() throws Exception {
			// TODO Auto-generated method stub
			int[] day = { 1, 2, 15, 30, 31 };
			int[] month = { 1, 2, 6, 11, 12 };
			int[] year = { 1900, 1901, 1975, 2049, 2050 };
			FileOutputStream fos = new FileOutputStream(destDir + "NextDate最坏情况测试用例.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "day", "month", "year", "期望值");
			CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

			int num = 0;
			for (int a : day) {
				for (int b : month) {
					for (int c : year) {
						csvPrinter.printRecord(++num, a, b, c, NextDate.getDate(a, b, c));
					}
				}
			}
			csvPrinter.flush();
			csvPrinter.close();
		}

		// 健壮性边界测试: 6n+1
		public static void test3RobustBoundaryValue() throws Exception {
			// TODO Auto-generated method stub
			int[] day = { 0, 1, 2, 15, 30, 31, 32 };
			int[] month = { 0, 1, 2, 6, 11, 12, 13 };
			int[] year = { 1899, 1900, 1901, 1975, 2049, 2050, 2051 };
			FileOutputStream fos = new FileOutputStream(destDir + "NextDate健壮边界测试用例.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "day", "month", "year", "期望值");
			CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

			int num = 0;
			for (int a : day) {
				for (int b : month) {
					for (int c : year) {
						if (a == 15 && b == 6 || a == 15 & c == 1975 || b == 6 && c == 1975) {
							csvPrinter.printRecord(++num, a, b, c, NextDate.getDate(a, b, c));
						}
					}
				}
			}
			csvPrinter.flush();
			csvPrinter.close();
		}

		// 健壮最坏情况测试: 7^n
		public static void test4RobustWorstBoundaryValue() throws Exception {
			// TODO Auto-generated method stub
			int[] day = { 0, 1, 2, 15, 30, 31, 32 };
			int[] month = { 0, 1, 2, 6, 11, 12, 13 };
			int[] year = { 1899, 1900, 1901, 1975, 2049, 2050, 2051 };
			FileOutputStream fos = new FileOutputStream(destDir + "NextDate健壮性最坏情况测试用例.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "day", "month", "year", "期望值");
			CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

			int num = 0;
			for (int a : day) {
				for (int b : month) {
					for (int c : year) {
						csvPrinter.printRecord(++num, a, b, c, NextDate.getDate(a, b, c));
					}
				}
			}
			csvPrinter.flush();
			csvPrinter.close();
		}
}
