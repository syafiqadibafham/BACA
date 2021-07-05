package com.malaysianmannheim.baca.ui;

public class Castle1Crown {
    private String title, percentProgress;
    private int background, iconCrown, titleColor;

    public Castle1Crown(String title, String percentProgress, int background, int iconCrown, int titleColor){
        this.title = title;
        //this.subTitle = subTitle;
        this.percentProgress = percentProgress;
        this.background = background;
        this.iconCrown = iconCrown;
        this.titleColor = titleColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPercentProgress() {
        return percentProgress;
    }

    public void setPercentProgress(String percentProgress) {
        this.percentProgress = percentProgress;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getIconCrown() {
        return iconCrown;
    }

    public void setIconCrown(int iconCrown) {
        this.iconCrown = iconCrown;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }
}
