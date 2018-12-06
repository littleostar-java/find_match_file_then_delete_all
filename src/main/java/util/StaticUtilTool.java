package util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class StaticUtilTool {

    // del name
    private String DEL_NAME = "node_modules";
    private FilenameFilter filenameFilter = (dir, name) ->
            name.contains(DEL_NAME) && name.lastIndexOf(DEL_NAME) == 0;

    /**
     * print the file name
     *
     * @param file
     */
    private void printDelPath(File file) {
//        System.out.println("deleted: " + file.getAbsolutePath());
    }

    public void delete_NodeModule_ByPath(String root_path) throws IOException {
        delete_NodeModule_ByPath(root_path, "");
    }

    /**
     * @param root_path where do you want to find node_modules , then delete it
     * @throws IOException
     */
    public void delete_NodeModule_ByPath(String root_path, String del_name) throws IOException {
        LinkedList<String> list = new LinkedList<String>();

        File rootDir = new File(root_path); // WebstormProjects root dir
        if (!rootDir.exists()) {
            System.out.println("not exists");
            System.exit(0);
        } else {
            LinkedList<String> pathList = new LinkedList<>();
            if (Objects.requireNonNull(del_name).length() == 0) {
                pathList = get_PathList(rootDir, list, filenameFilter);
            } else {
                FilenameFilter your_filter = (dir, name) ->
                        name.contains(del_name) && name.lastIndexOf(del_name) == 0;
                pathList = get_PathList(rootDir, list, your_filter);
            }
            for (String str : pathList) {
                delete_File(str);
                System.out.println("deleted:\n\t\t" + str);
            }
        }
    }

    /**
     * @param root_file
     * @param list           container "node_modules" of list
     * @param filenameFilter
     * @return
     * @throws IOException
     */
    private LinkedList<String> get_PathList(File root_file, LinkedList<String> list, FilenameFilter filenameFilter)
            throws IOException {
        if (root_file.isDirectory() && Objects.requireNonNull(root_file.list()).length != 0) {
            File[] files_havefilter = root_file.listFiles(filenameFilter);
            File[] files_nofilter = root_file.listFiles();

            if (files_nofilter.length != 0) {
                for (File file_no : files_nofilter) {
                    if (files_havefilter.length == 0) {
                        get_PathList(file_no, list, filenameFilter);
                    }
                }
                for (File file_have : files_havefilter) {
                    String absolutePath = file_have.getAbsolutePath();
                    list.add(absolutePath);
                }
            }
        }
        return list;
    }

    /**
     * delete file by path
     *
     * @param path absolute path of file
     * @throws IOException
     */
    private void delete_File(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            String[] list = file.list();
            assert list != null;
            if (list.length == 0) {
                file.delete();
                printDelPath(file);
            } else {
                for (String temp : list) {
                    File fileDel = new File(file, temp);
                    delete_File(fileDel.getAbsolutePath());
                }
                if (file.list().length == 0) {
                    file.delete();
                    printDelPath(file);
                }
            }
        } else {
            file.delete();
            printDelPath(file);
        }
    }
}
