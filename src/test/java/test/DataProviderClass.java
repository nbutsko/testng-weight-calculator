package test;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "heightWithValidValuesForExcessBodyWeight")
    public Object[] heightWithValidValuesForExcessBodyWeight() {
        return new Object[]{"50", "150"};
    }

    @DataProvider(name = "heightWithInvalidValues")
    public Object[] heightWithInvalidValues() {
        return new Object[]{"49", "301", "0", "-10", "1000000", "a", "A", "-", "a*1A"};
    }

    @DataProvider(name = "weightWithInvalidValues")
    public Object[] weightWithInvalidValues() {
        return new Object[]{"2", "501", "0", "-10", "1000000", "a", "A", "-", "a*1A"};
    }

    @DataProvider(name = "nameWithValidValues")
    public Object[] nameWithValidValues() {
        return new Object[]{"Name", "A"};
    }

    @DataProvider(name = "nameWithInvalidValues")
    public Object[] nameWithInvalidValues() {
        return new Object[]{" ", "0", ""};
    }

    @DataProvider(name = "genderWithInvalidValues")
    public Object[] genderWithInvalidValues() {
        return new Object[]{"М", "Ж"};
    }
}
