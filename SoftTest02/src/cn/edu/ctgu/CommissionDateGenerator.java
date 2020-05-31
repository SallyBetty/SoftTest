package cn.edu.ctgu;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CommissionDateGenerator {
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
		int[] lock = { 1, 2, 35, 69, 70 };
		int[] stock = { 1, 2, 40, 79, 80 };
		int[] barrel = { 1, 2, 45, 89, 90 };
		FileOutputStream fos = new FileOutputStream(destDir + "佣金问题一般边界测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "枪机", "枪托", "枪管", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : lock) {
			for (int b : stock) {
				for (int c : barrel) {
					if (a == 35 && b == 40 || a == 35 & c == 45 || b == 40 && c == 45) {
						csvPrinter.printRecord(++num, a, b, c, Commission.getCommission(a, b, c));
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
		int[] lock = { 1, 2, 35, 69, 70 };
		int[] stock = { 1, 2, 40, 79, 80 };
		int[] barrel = { 1, 2, 45, 89, 90 };
		FileOutputStream fos = new FileOutputStream(destDir + "佣金问题最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "枪机", "枪托", "枪管", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : lock) {
			for (int b : stock) {
				for (int c : barrel) {
					csvPrinter.printRecord(++num, a, b, c, Commission.getCommission(a, b, c));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();
	}

	// 健壮性边界测试: 6n+1
	public static void test3RobustBoundaryValue() throws Exception {
		// TODO Auto-generated method stub
		int[] lock = { 0, 1, 2, 35, 69, 70, 71 };
		int[] stock = { 0, 1, 2, 40, 79, 80, 81 };
		int[] barrel = { 0, 1, 2, 45, 89, 90, 91 };
		FileOutputStream fos = new FileOutputStream(destDir + "佣金问题健壮边界测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "枪机", "枪托", "枪管", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : lock) {
			for (int b : stock) {
				for (int c : barrel) {
					if (a == 35 && b == 40 || a == 35 & c == 45 || b == 40 && c == 45) {
						csvPrinter.printRecord(++num, a, b, c, Commission.getCommission(a, b, c));
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
		int[] lock = { 0, 1, 2, 35, 69, 70, 71 };
		int[] stock = { 0, 1, 2, 40, 79, 80, 81 };
		int[] barrel = { 0, 1, 2, 45, 89, 90, 91 };
		FileOutputStream fos = new FileOutputStream(destDir + "佣金问题健壮性最坏情况测试用例.csv");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "枪机", "枪托", "枪管", "期望值");
		CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

		int num = 0;
		for (int a : lock) {
			for (int b : stock) {
				for (int c : barrel) {
					csvPrinter.printRecord(++num, a, b, c, Commission.getCommission(a, b, c));
				}
			}
		}
		csvPrinter.flush();
		csvPrinter.close();
	}
}
