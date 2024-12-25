package beandependencies;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hqz
 * @create 2023/9/16 10:38
 * bean 统计计数器
 */
public class BeanCalcPostProcessor implements BeanPostProcessor {
    private Map<String, Long> costMap = new HashMap<>();

    /**
     * 前置处理
     *
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        costMap.put(s, System.currentTimeMillis());
        return o;
    }

    /**
     * 后置处理
     *
     * @param o
     * @param s
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (costMap.containsKey(s)) {
            long start = costMap.get(s);
            long cost = System.currentTimeMillis() - start;
            if (cost > 0) {
                costMap.put(s, cost);
                System.out.println("bean: " + s + "cost: " + cost);
            }
        }
        return o;
    }
}
