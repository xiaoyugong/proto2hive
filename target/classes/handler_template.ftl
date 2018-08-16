package ${packagePath};

import com.handge.proto.${className};

public class ${className}Handler extends AbstractHandler<${className}> {
    @Override
    public void handle(${className} ${lowerClassName}) throws Exception {
        String objectStr = ${lowerClassName}.toString();
        String tableName = "t_${lowerClassName}";
        execute(objectStr, tableName);
    }
}