package com.example.demo.model.Contract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import com.example.demo.model.Contract.Contract.PaymentType;
import com.example.demo.model.Customer.Customer;

public class ContractListImpl implements ContractInterface {

	private Vector<Contract> ContractVector;
	public com.example.demo.model.Customer.CustomerListImpl CustomerListImpl;

	public SimpleDateFormat SDF;

	public ContractListImpl() {
		this.ContractVector = new Vector<Contract>();
		this.SDF = new SimpleDateFormat("yyyy-MM-dd");
	}

	public Vector<Contract> getContractVector() {
		return this.ContractVector;
	}

	public void setCustomerListImpl(com.example.demo.model.Customer.CustomerListImpl customerListImpl) {
		this.CustomerListImpl = customerListImpl;
	}

	public boolean add(Contract Contract) {
		this.ContractVector.add(Contract);
		return true;
	}


	public Contract search(int ContractID) {
		for(Contract contract : this.ContractVector){
			if (contract.getContractID() == ContractID) {
				return contract;
			}
		}
		return null;
	}

	public boolean ReContract(int ContractID, Scanner sc) {
		System.out.println("***********���� �ϱ�************");

		for(Contract contract : this.ContractVector) { 
			if(contract.getContractID() == ContractID) {
				for(Customer customer : this.CustomerListImpl.getCustomerVector()) {
					if(customer.getCustomerID() == contract.getCustomerID()) {

						System.out.println("���̸�: "+ customer.getCustomerName());
						System.out.println("����ó: "+ customer.getPhoneNum());
						System.out.println("��ุ����: "+ contract.getContractExpirationDate());
						System.out.println("�������������Ⱓ: "+ contract.getPersonalInformationRetentionPeriod());

						//modify information at 
						System.out.println("*****������ �����մϴ�****");
						System.out.println("���ο� ��ุ������ �Է��ϼ���");
						Date ContractExpirationDate = null;

						try {
							ContractExpirationDate = SDF.parse(sc.next());
						} catch (ParseException e) {
							e.printStackTrace();
						}
						contract.setContractExpirationDate(ContractExpirationDate);

						System.out.println("������ �κ��� �Է��ϼ��� 1. ���¹�ȣ, 2. ������, 3. ���Թ�� " ); // how to express select 1 of 4 
						int menueNum = 0;
						while(true) {
							if(!sc.hasNextInt()) {
								sc.next();
								System.err.println("���ڸ� �Է��Ͻÿ�. 1. ���¹�ȣ, 2. ������, 3. ���Թ��");
							}else {
								menueNum = sc.nextInt();
								if(!(menueNum>0 && menueNum<4)) {
									System.err.println("���� �޴� �� �����Ͻÿ�. 1. ���¹�ȣ, 2. ������, 3. ���Թ��");
								}else {
									break;
								}
							}
						}

						switch(menueNum) {
						case 1: 
							System.out.println("���ο� ���¹�ȣ�� �Է��ϼ���");
							while(true) {
								if(!sc.hasNextInt()) {
									System.out.println("�Է��� �߸��Ǿ����ϴ�. �Է� ��Ȯ�� ��Ź�մϴ�");    //���_   
								}
								else{
									customer.getPersonalInformation().setAccountNumber(sc.nextInt());
									break;
								}                  
							}


						case 2:
							System.out.println("���ο� �������� �Է��ϼ���");
							Date PaymentDate = null;
							try {
								PaymentDate = SDF.parse(sc.next());
								//���_   System.out.println("�Է��� �߸��Ǿ����ϴ�. �Է� ��Ȯ�� ��Ź�մϴ�");
							} catch (ParseException e) {
								e.printStackTrace();
							}
							contract.setPaymentDate(PaymentDate);
							break;

						case 3:
							System.out.println("���ο� ���Թ���� �Է��ϼ��� 1.creditCard, 2.e_bancking, 3.accountTransfer");
							//���_   System.out.println("�Է��� �߸��Ǿ����ϴ�. �Է� ��Ȯ�� ��Ź�մϴ�");
							switch(sc.nextInt()) {
							case 1: 
								contract.setPaymentType(PaymentType.creditCard);
								break;
							case 2: contract.setPaymentType(PaymentType.e_bancking);
							break;
							case 3: contract.setPaymentType(PaymentType.accountTransfer);
							break;
							default:
								break;
							}
							break;
						default:
							break;
						}
					}
				}
				// send message subscription   
				System.out.println("������ �Ϸ�Ǿ����ϴ� û�༭�� �߼��Ͽ����ϴ�");   
				//����_ System.out.println("���� ������ �߼ۿ� �����Ͽ����ϴ�. ��õ� ��Ź�帳�ϴ�");
				return true;
			}
		}      
		System.out.println("�˻� ��� CustomerID Ȥ�� ContractID�� Vecotor�� ���� ���� ����");
		return false;   
	}

	public Vector<Contract> searchUnpaidCustomer() { 
		System.out.println("********�̳��� ��ȸ�ϱ�*******");
		Date now = new Date();
		for(Contract contract : ContractVector) {
			if(now.after(contract.getContractExpirationDate())) {
				//show all information of contract
				System.out.println("��� ID :"+ contract.getContractID() + ", �� ID :"+ contract.getCustomerID()+ 
						", ������ :" + contract.getPaymentDate()+ ", ���Կ��� :" + false +", ���Թ�� :" + contract.getPaymentType());
			}
		}
		return null;
	}

	public Vector<Contract> searchFullContractCustomer(Scanner sc) { 
		System.out.println("********�������� ��ȸ�ϱ�*******");
		Date now = new Date();
		//����_System.out.println("��� ���� �ε��� �����Ͽ����ϴ�. �ٽ� �õ��Ͽ� �ֽʽÿ�");
		for(Contract contract : ContractVector) {
			if(now.after(contract.getContractExpirationDate())) {
				System.out.println("�� ID :"+ contract.getCustomerID()+ "��� ID :"+ contract.getContractID());      
			}
		}
		System.out.println("������ ������ ���ID�� �Է��ϼ���");
		while(true) {
			if(!sc.hasNextInt()) {
				sc.next();
				System.err.println("���ڸ� �Է��Ͻÿ�. ���ID");
			}else {
				ReContract(sc.nextInt(), sc); 
				break;
			}
		}
		return null;
	}
}