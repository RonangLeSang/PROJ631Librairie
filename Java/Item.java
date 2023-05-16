public abstract class Item {
    //Classe abstraite permettant le polymorphisme des items
    public abstract String[] toSQL();

    public abstract String[] suppressSelf();
}
