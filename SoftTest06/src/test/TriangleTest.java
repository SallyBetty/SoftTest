package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
	@ParameterizedTest
	@DisplayName("������һ��߽����")
	@CsvFileSource(resources = "/������һ��߽��������.csv", numLinesToSkip = 1)
	public void testNormalBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("�����������߽����")
	@CsvFileSource(resources = "/������������������.csv", numLinesToSkip = 1)
	public void testWorstCaseBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("�����ν�׳�߽����")
	@CsvFileSource(resources = "/�����ν�׳�߽��������.csv", numLinesToSkip = 1)
	public void testRobustBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}

	@ParameterizedTest
	@DisplayName("�����ν�׳��������")
	@CsvFileSource(resources = "/�����ν�׳��������������.csv", numLinesToSkip = 1)
	public void testRobustWorstCaseBoundary(Integer num, Integer a, Integer b, Integer c, String type) {
		assertEquals(Triangle.triangleCalculate(a, b, c), type);
	}
}
