public class ProjectCostVisitor implements ProjectVisitor {
    private double totalCost;
    private double hourlyRate;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setHourlyRate(double rate) {
        hourlyRate = rate;
    }

    public void resetTotalCost() {
        totalCost = 0.0;
    }

    public void visit(DependentTask p) {
        double taskCost = p.getTimeRequired() * hourlyRate;
        taskCost *= p.getDependencyWeightingFactor();
        totalCost += taskCost;
    }

    public void visit(Deliverable p) {
        totalCost += p.getMaterialsCost() + p.getProductionCost();

    }

    public void visit(Task p) {
        totalCost += p.getTimeRequired() * hourlyRate;
    }

    public void visit(Project p) {
    }
}