package sample;

public class HierarchicalController <P extends HierarchicalController<?>> {

    public P getParentController();
    public void setParentController(P parent);

}
