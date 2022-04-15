package com.beans;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IMCBeans {

	private double poids = 0.0;
	private double taille = 0.0;
	private String unite = "metre";
	private String imc;
	private boolean interpretation;
	private String inter;
	private HashMap<String, Object> units = new HashMap<String, Object>();

	public IMCBeans() {
		units.put("Metre", "metre");
		units.put("Centimetre", "cent");
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public boolean isInterpretation() {
		return interpretation;
	}

	public String getInter() {
		return inter;
	}

	public void setInter(String inter) {
		this.inter = inter;
	}

	public void setInterpretation(boolean interpretation) {
		this.interpretation = interpretation;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double prix) {
		this.poids = prix;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public String getImc() {
		return imc;
	}

	public void setImc(String imc) {
		this.imc = imc;
	}

	public HashMap<String, Object> getUnits() {
		return units;
	}

	public void setUnits(HashMap<String, Object> units) {
		this.units = units;
	}

	public void calculer() {
		double t = taille;
		if (unite.equals("cent"))
			;
		t /= 100;

		double res = poids / taille;

		imc = String.format("%.2f Kg/m", res);

		if (interpretation) {
			if (res <= 18.5)
				inter = "insuffisance pondérale";
			else if (res <= 25)
				inter = "poids normal";
			else if (res <= 30)
				inter = "surpoids";
			else
				inter = "obésité";
		} else
			inter = "";

	}

	public void init() {
		poids = 0;
		taille = 0;
		unite = "metre";
		inter = "";
		imc = "";
	}
}
