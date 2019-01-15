package shixin.aopdemo.aspect_intertype;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * intertype切入
 */
@Aspect
public class AspectJInterType {
    private static final String TAG = AspectJInterType.class.getSimpleName();

    /**
     * 对人这个接口：
     * 1. 指定其切入点为Baby类
     * 2. 指定真正的实现类教师类
     */
    @DeclareParents(value = "shixin.aopdemo.aspect_intertype.Baby", defaultImpl = Teacher.class)
    private People people;

    /**
     * 教师类，实现人的接口
     */
    public static class Teacher implements People {

        /**
         * 提供年龄获取
         *
         * @return
         */
        @Override
        public int getAge() {
            return 18;
        }
    }
}