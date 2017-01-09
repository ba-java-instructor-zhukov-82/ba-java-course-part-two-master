package java_se._2_serialization.paths_util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsUtil {

    public static void main(String[] args) {
        Path projectPath = Paths.get(getProjectPath());
        System.out.println(pathToString(projectPath));
        System.out.println(getClassPath(PathsUtil.class, CodeSourceDirectory.SRC));
        System.out.println(getClassDirectory(PathsUtil.class, CodeSourceDirectory.SRC));
    }

    public static String getProjectPath() {
        return Paths.get("").toAbsolutePath().toString().replace('/', '\\') + '/';
    }

    public static String getClassPath(Class targetClass, CodeSourceDirectory directory) {
        return getProjectPath() + directory.getDirectoryPath() +  targetClass.getName().replace('.', '/');
    }

    public static String getClassDirectory(Class targetClass, CodeSourceDirectory directory) {
        return getClassPath(targetClass,directory)
                  .substring(0, getClassPath(targetClass, directory).lastIndexOf(targetClass.getSimpleName()));
    }

    public static String pathToString(Path path) {
        return path.toAbsolutePath().toString();
    }

    public static String getPackageFileAccess(Class targetClass, String filePath) {
        return getClassDirectory(targetClass, CodeSourceDirectory.SRC) + filePath;
    }

    public enum CodeSourceDirectory {
        SRC("/src/"), OUT("/src/production");

        private String directoryPath;

        public String getDirectoryPath() {
            return directoryPath;
        }

        CodeSourceDirectory(String directoryPath) {
            this.directoryPath = directoryPath;
        }
    }
}
