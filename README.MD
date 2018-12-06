
---

- find_match_file_then_delete_all

```java
public class Sample {

    public static void main(String[] args) throws IOException {
        String root_path = "C:" + File.separator + "WebstormProjects";

        StaticUtilTool tool = new StaticUtilTool();
        tool.do_delete_by_path( root_path, "node_modules");
    }

}

```

---

end