package cn.edu.ctgu;

public class Commission {
	public static String getCommission(int locks, int stocks, int barrels) {
		double lockprice = 45; // 枪机
		double stockprice = 30; // 枪托
		double barrelprice = 25; // 枪管

		while (locks == -1) {
			return "本月销售结束";
		}
		if (locks != -1) {
			if (locks < 1 || locks > 70) {
				return "枪机数不能为负数且限制一个月最多售出70个";
			} else if (stocks < 1 || stocks > 80) {
				return "枪托数不能为负数且限制一个月最多售出80个";
			} else if (barrels < 1 || barrels > 90) {
				return "枪管数不能为负数且限制一个月最多售出90个";
			}
		}

		double locksales = locks * lockprice;
		double stocksales = stocks * stockprice;
		double barrelsales = barrels * barrelprice;
		double sales = locksales + stocksales + barrelsales;
		double commission = 0;

		if (sales > 1800) {
			commission = 0.10 * 1000;
			commission = commission + 0.15 * 800;
			commission = commission + 0.2 * (sales - 1800);
			return Double.toString(commission);
		} else if (sales > 1000) {
			commission = 0.10 * 1000;
			commission = commission + 0.15 * (sales - 1000);
			return Double.toString(commission);
		} else {
			commission = 0.10 * sales;
			return Double.toString(commission);
		}
	}
}
