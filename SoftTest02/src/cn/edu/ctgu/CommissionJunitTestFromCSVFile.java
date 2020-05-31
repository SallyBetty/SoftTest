package cn.edu.ctgu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CommissionJunitTestFromCSVFile {
	@ParameterizedTest
	@DisplayName("佣金问题一般边界测试")
	@CsvFileSource(resources = "/佣金问题一般边界测试用例.csv", numLinesToSkip = 1)
	public void testNormalBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Commission.getCommission(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("佣金问题最坏情况边界测试")
	@CsvFileSource(resources = "/佣金问题最坏情况测试用例.csv", numLinesToSkip = 1)
	public void testWorstCaseBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Commission.getCommission(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("佣金问题健壮边界测试")
	@CsvFileSource(resources = "/佣金问题健壮边界测试用例.csv", numLinesToSkip = 1)
	public void testRobustBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Commission.getCommission(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("佣金问题健壮最坏情况测试")
	@CsvFileSource(resources = "/佣金问题健壮性最坏情况测试用例.csv", numLinesToSkip = 1)
	public void testRobustWorstCaseBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Commission.getCommission(a, b, c), type);
	}
}
