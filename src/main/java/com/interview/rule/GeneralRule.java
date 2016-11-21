package com.interview.rule;

import com.interview.bean.CoefficientBean;
import com.interview.exception.NegativeDescriminantException;

public class GeneralRule implements IQudraticRule {

	private double leadingCoefficient, secondCoefficient, freeMember;

	@Override
	public CoefficientBean getResult(CoefficientBean coefficientBean) {
		parseStringToDouble(coefficientBean);
		coefficientBean.setDiscriminant(findDiscriminant());
		findResult(coefficientBean);
		return coefficientBean;
	}

	private void parseStringToDouble(CoefficientBean coefficientBean) {
		leadingCoefficient = Double.parseDouble(coefficientBean.getLeadingCoefficien());
		secondCoefficient = Double.parseDouble(coefficientBean.getSecondCoefficien());
		freeMember = Double.parseDouble(coefficientBean.getFreeMember());
	}

	private Double findDiscriminant() {
		return secondCoefficient * secondCoefficient - 4 * leadingCoefficient * freeMember;
	}

	private void findResult(CoefficientBean coefficientBean) {
		if (coefficientBean.getDiscriminant() > 0)
			isPositive(coefficientBean);
		else if (coefficientBean.getDiscriminant() == 0)
			isZero(coefficientBean);
		else
			throw new NegativeDescriminantException();
	}

	private void isPositive(CoefficientBean coefficientBean) {
		double firstVariable = (-secondCoefficient + Math.sqrt(coefficientBean.getDiscriminant())) / 2
				* leadingCoefficient;
		double secondVariable = (-secondCoefficient - Math.sqrt(coefficientBean.getDiscriminant())) / 2
				* leadingCoefficient;
		coefficientBean.setFirstVariable(firstVariable);
		coefficientBean.setSecondVariable(secondVariable);
	}

	private void isZero(CoefficientBean coefficientBean) {
		double variable = -secondCoefficient / 2 * leadingCoefficient;
		coefficientBean.setFirstVariable(variable);
		coefficientBean.setSecondVariable(variable);
	}

}
