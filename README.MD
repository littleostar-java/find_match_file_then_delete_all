
---

- find_match_file_then_delete_all

```
public class Sample {

    // 1 need a root_path
    // 2 default delete name is "node_modules"

    public static void main(String[] args) throws IOException {
        String root_path = "C:" + File.separator + "WebstormProjects";

        StaticUtilTool tool = new StaticUtilTool();
        tool.delete_NodeModule_ByPath("node_modules",root_path); // it's ok

        // ---------------------------------------------------------------------------
        // test, result is success
//        String del_name = "新建文本文档.txt"; // like demo
//        tool.delete_NodeModule_ByPath(root_path, del_name);
        // ---------------------------------------------------------------------------

    }

}

```

---

end