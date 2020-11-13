package com.example.demo.model.Accident;

import java.util.Vector;

public class AccidentListImpl implements AccidentInterface{

	private Vector<Accident> accidentVector;
	
	public Vector<Accident> getAccidentVector() {return this.accidentVector;}

	public AccidentListImpl(){
		this.accidentVector = new Vector<Accident>();
	}

	public boolean add(Accident accident) {
		if(!(accident == null)) {
			this.accidentVector.add(accident);
			return true;
		} else {
			return false;
		}
	}

	//�����Ҷ� InsuranceID�� �˻��ؼ� �����ϴ��� AccidentID�� �����ϴ� �� �´°� ���Ƽ� ����.
	public boolean delete(int accidentID) {
		for(Accident accident : this.accidentVector) {
			if(accident.getAccidentID() == accidentID) {
				this.accidentVector.remove(accident);
				return true;
			}
		}
		return false;
	}
	
	//�����Ҷ� InsuranceID�� �˻��ؼ� �����ϴ��� AccidentID�� �����ϴ� �� �´°� ���Ƽ� ����.
	public Accident search(int accidentID) {
		for(Accident accident : this.accidentVector) {
			if(accident.getAccidentID() == accidentID) {
				return accident;
			}
		}
		return new Accident();
	}
}