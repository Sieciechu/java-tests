package pl.nstrefa.wojciechmocek;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Branch> branchList = new ArrayList<>();

    public void createBranch(String branchName) {
        branchList.add(new Branch(branchName));
    }

    List<Branch> getBranchList() {
        return branchList;
    }
}
