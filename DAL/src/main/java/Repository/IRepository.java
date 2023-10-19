package Repository;

public interface IRepository {
    public void Save(String info, String filename);
    public String[] Load(String filename);
}
