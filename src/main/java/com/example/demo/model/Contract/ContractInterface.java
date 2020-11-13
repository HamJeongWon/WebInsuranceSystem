package com.example.demo.model.Contract;

import java.util.Scanner;
import java.util.Vector;

public interface ContractInterface {

	public boolean add(Contract Contract);

	public boolean ReContract(int ContractID, Scanner scanner);

	public Contract search(int ContractID);

	public Vector<Contract> searchUnpaidCustomer();

	public Vector<Contract> searchFullContractCustomer(Scanner scanner);

}