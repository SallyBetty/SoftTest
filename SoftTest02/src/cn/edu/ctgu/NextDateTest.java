package cn.edu.ctgu;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

// 参数化运行器
@RunWith(Parameterized.class)
public class NextDateTest {

	private int day, month, year;
	private String nextdateString;

	@Before
	public void setUp() throws Exception {
	}

	public NextDateTest(int day, int month, int year, String nextdateString) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.nextdateString = nextdateString;
	}

	@Parameters
	public static Collection<Object[]> getData() {
		return Arrays.asList(new Object[][] {
			{ 31, 12, 1899, "年份错误"},
			{ 29, 8, 2000, "30-8-2000" }, 
			{ 16, 8, 1964, "17-8-1964" },
			{ 31, 12, 2020, "1-1-2021" }, 
			{ 25, 8, 2008, "26-8-2008" }, 
			{ 31, 4, 2015, "日期错误" }, 
			{ 28, 2, 2012, "29-2-2012" },
			{ 27, 5, 2020, "28-5-2020" }, 
			{ 16, 2, 1999, "17-2-1999" }, 
			{ 24, 1, 2017, "25-1-2017" }, 
			{ 25, 13, 2012, "月份错误"},
		});
	}

	@Test
    public void testJunitNextDate() {
        extracted();
    }

	@SuppressWarnings("deprecation")
	private void extracted() {
		assertEquals(this.nextdateString, NextDate.getDate(day, month, year));
	}

}

