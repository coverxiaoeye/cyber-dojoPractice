package com.coverxiaoeye.cyberdojo._11storagerobot;

public interface Filter {
    public boolean isSatisfy(Product pro);
}

class ColorFilter implements Filter {
    private Color color;

    public ColorFilter(Color color) {
        this.color = color;
    }

    public boolean isSatisfy(Product pro) {
        if (color.equals(pro.getColor())) {
            return true;
        }
        return false;
    }
}

class WeightLessFilter implements Filter {
    private int valveWeight;

    public WeightLessFilter(int valveWeight) {
        this.valveWeight = valveWeight;
    }

    public boolean isSatisfy(Product pro) {
        if (pro.getWeight() < valveWeight) {
            return true;
        }
        return false;
    }
}

class AND implements Filter {
    private Filter lfilter;
    private Filter rfilter;

    public AND(Filter lfilter, Filter rfilter) {
        this.lfilter = lfilter;
        this.rfilter = rfilter;
    }

    public boolean isSatisfy(Product pro) {
        return lfilter.isSatisfy(pro) && rfilter.isSatisfy(pro);
    }
}

class OR implements Filter {
    private Filter lfilter;
    private Filter rfilter;

    public OR(Filter lfilter, Filter rfilter) {
        this.lfilter = lfilter;
        this.rfilter = rfilter;
    }

    public boolean isSatisfy(Product pro) {
        return lfilter.isSatisfy(pro) || rfilter.isSatisfy(pro);
    }
}

class NOT implements Filter {
    private Filter filter;

    public NOT(Filter filter) {
        this.filter = filter;
    }

    public boolean isSatisfy(Product pro) {
        return !filter.isSatisfy(pro);
    }
}
