public interface ProjectVisitor {
    public void visit(Deliverable p);

    public void visit(Task p);

    public void visit(DependentTask p);

    public void visit(Project p);
}