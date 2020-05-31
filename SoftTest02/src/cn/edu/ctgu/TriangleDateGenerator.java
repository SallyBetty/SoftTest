package cn.edu.ctgu;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class TriangleDateGenerator {
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
		int[] sideA = { 1, 2, 50, 99, 100 };
		int[] sideB = { 1, 2, 50, 99, 100 };
		int[] sideC = { 1, 2, 50, 99, 100 };
		FileOutputStream fos = new FileOutputStream(destDir + "三角形一般边界测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : sideA) {
			for (int b : sideB) {
				for (int c : sideC) {
					if (a == b && a == 50 || a == c & a == 50 || b == c && b == 50) {
						csvPrinter.printRecord(++num, a, b, c, Triangle.triangleCalculate(a, b, c));
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
		int[] sideA = { 1, 2, 50, 99, 100 };
		int[] sideB = { 1, 2, 50, 99, 100 };
		int[] sideC = { 1, 2, 50, 99, 100 };
		FileOutputStream fos = new FileOutputStream(destDir + "三角形最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : sideA) {
			for (int b : sideB) {
				for (int c : sideC) {
					csvPrinter.printRecord(++num, a, b, c, Triangle.triangleCalculate(a, b, c));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();

	}

	// 健壮性边界测试: 6n+1
	public static void test3RobustBoundaryValue() throws Exception {
		// TODO Auto-generated method stub
		int[] sideA = { 0, 1, 2, 50, 99, 100, 101 };
		int[] sideB = { 0, 1, 2, 50, 99, 100, 101 };
		int[] sideC = { 0, 1, 2, 50, 99, 100, 101 };
		FileOutputStream fos = new FileOutputStream(destDir + "三角形健壮边界测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : sideA) {
			for (int b : sideB) {
				for (int c : sideC) {
					if (a == b && a == 50 || a == c & a == 50 || b == c && b == 50) {
						csvPrinter.printRecord(++num, a, b, c, Triangle.triangleCalculate(a, b, c));
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
		int[] sideA = { 0, 1, 2, 50, 99, 100, 101 };
		int[] sideB = { 0, 1, 2, 50, 99, 100, 101 };
		int[] sideC = { 0, 1, 2, 50, 99, 100, 101 };
		FileOutputStream fos = new FileOutputStream(destDir + "三角形健壮性最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : sideA) {
			for (int b : sideB) {
				for (int c : sideC) {
					csvPrinter.printRecord(++num, a, b, c, Triangle.triangleCalculate(a, b, c));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();
	}
}
