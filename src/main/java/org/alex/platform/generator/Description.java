package org.alex.platform.generator;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 根据约束信息生成标题
 */
@Component
public class Description {
    public String desc4Null(String key, String desc) {
        return String.format("%s<%s>为null ", desc, key);
    }

    public String desc4NotNull(String key, String desc) {
        return String.format("%s<%s>非null ", desc, key);
    }

    public String desc4Empty(String key, String desc) {
        return String.format("%s<%s>为空字符串 ", desc, key);
    }

    public String desc4NotEmpty(String key, String desc) {
        return String.format("%s<%s>非空字符串 ", desc, key);
    }

    public String desc4Length(String key, String desc, int minLen, int maxLen) {
        return String.format("%s<%s>长度在区间[%s,%s]内 ", desc, key, minLen, maxLen);
    }

    public String desc4LengthRepeat(String key, String desc, int minLen, int maxLen) {
        return String.format("%s<%s>长度在区间[%s,%s]内-重复 ", desc, key, minLen, maxLen);
    }

    public String desc4LessLength(String key, String desc, int minLen, int step) {
        return String.format("%s<%s>长度为最小长度<%s>-%s ", desc, key, minLen, step);
    }

    public String desc4GreaterLength(String key, String desc, int maxLen, int step) {
        return String.format("%s<%s>长度为最大长度<%s>+%s ", desc, key, maxLen, step);
    }

    public String desc4EqualsMinLength(String key, String desc, int minLen) {
        return String.format("%s<%s>长度恰好为最小长度<%s> ", desc, key, minLen);
    }

    public String desc4EqualsMaxLength(String key, String desc, int maxLen) {
        return String.format("%s<%s>长度恰好为最大长度<%s> ", desc, key, maxLen);
    }

    public String desc4Size(String key, String desc, BigDecimal min, BigDecimal max) {
        return String.format("%s<%s>大小在区间[%s,%s]内 ", desc, key, min, max);
    }

    public String desc4LessSize(String key, String desc, BigDecimal min, BigDecimal step) {
        return String.format("%s<%s>为最小值<%s>-%s ", desc, key, min, step);
    }

    public String desc4GreaterSize(String key, String desc, BigDecimal max, BigDecimal step) {
        return String.format("%s<%s>为最大值<%s>+%s ", desc, key, max, step);
    }

    public String desc4EqualsMinSize(String key, String desc, BigDecimal min) {
        return String.format("%s<%s>恰好为最小值<%s> ", desc, key, min);
    }

    public String desc4EqualsMaxSize(String key, String desc, BigDecimal max) {
        return String.format("%s<%s>恰好为最大值<%s> ", desc, key, max);
    }

    public String desc4SizeRepeat(String key, String desc, BigDecimal min, BigDecimal max) {
        return String.format("%s<%s>大小在区间[%s,%s]内-重复 ", desc, key, min, max);
    }

    public String desc4InDb(String key, String desc) {
        return String.format("%s<%s>值存在于表内 ", desc, key);
    }

    public String desc4NotInDb(String key, String desc) {
        return String.format("%s<%s>值不存在于表内 ", desc, key);
    }

    public String desc4DbRepeat(String key, String desc) {
        return String.format("%s<%s>值存在于表内-重复 ", desc, key);
    }

    public String desc4InArray(String key, String desc) {
        return String.format("%s<%s>值存在于数组内 ", desc, key);
    }

    public String desc4NotInArray(String key, String desc) {
        return String.format("%s<%s>值不存在于数组内 ", desc, key);
    }

    public String desc4ArrayRepeat(String key, String desc) {
        return String.format("%s<%s>值存在于数组内-重复 ", desc, key);
    }

    public String desc4Const(String key, String desc, Object value) {
        return String.format("%s<%s>值为常量%s ", desc, key, value);
    }

    public static void main(String[] args) {
        Description description = new Description();
        System.out.println(description.desc4EqualsMinLength("name", "名称", 10));
    }
}
