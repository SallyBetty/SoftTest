package cn.edu.ctgu;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//参数化运行器
@RunWith(Parameterized.class)
public class CommissionTest {
	private int locks, stocks, barrels;
	private String commission;
	
	@Before
	public void setUp() throws Exception {
		
	}

	public CommissionTest(int locks, int stocks, int barrels, String commission) {
		super();
		this.locks = locks;
		this.stocks = stocks;
		this.barrels = barrels;
		this.commission = commission;
	}
	
	@Parameters
	public static Collection<Object[]> getDate() {
		return Arrays.asList(new Object[][] {
			{ -1, 12, 18, "本月销售结束"},
			{ 29, 8, 20, "269.0" }, 
			{ 16, 8, 97, "枪管数不能为负数且限制一个月最多售出90个" },
			{ 31, 85, 20, "枪托数不能为负数且限制一个月最多售出80个" }, 
			{ 75, 8, 58, "枪机数不能为负数且限制一个月最多售出70个" }, 
			{ 31, 4, 15, "238.0" }, 
			{ 28, 28, 12, "340.0" },
			{ 27, 25, 53, "518.0" }, 
			{ 16, 59, 89, "803.0" }, 
			{ 24, 18, 17, "269.0" }, 
			{ 25, 13, 12, "223.0"},
		});
	}

	
	@Test
 public void testJunitNextDate() {
     extracted();
 }

	@SuppressWarnings("deprecation")
	private void extracted() {
		assertEquals(this.commission, Commission.getCommission(locks, stocks, barrels));
	}
}
