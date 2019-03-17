package lucacipaul.mealplus;

public abstract class IApprovable {

    private boolean approved;

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
