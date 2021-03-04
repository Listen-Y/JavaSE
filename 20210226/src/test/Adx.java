package test;

public enum Adx {

    toutiao(true),
    gdt(true),
    momo(true),
    inmobi(true),
    google(true),
    fancy(true),
    iqiyi(true),
    didi,
    kuaishou_rta,
    baidu(true),
    nex(true),
    uc(true),
    toutiao_direct,
    gdt_direct,
    wechat_moments,
    sohu(true),
    baidu_sem,
    sohunews(true),
    baidu_feed,
    mi_store,
    vivo_store,
    oppo_store,
    huawei_store,
    apple_store,
    sogou_sem,
    shenma_sem,
    qimai,
    netease_direct,
    kuaishou_rtb(true),
    uc_direct,
    netease_music(true),
    jd(true),
    qihoo(true),
    mi(true),
    sogou(true),
    youxuan(true),
    huawei_app,
    zhihu(true),
    qihoo_sem,
    weibo_direct,
    iflytek(true),
    momo_launcher(true),
    mgtv(true),
    inmobi_rta,
    dingdang,
    jupeng,
    qutoutiao_direct,
    bilibili_direct,
    cpa;

    private boolean isDsp;

    private Adx() {
        this.isDsp = false;
    }

    private Adx(boolean isDsp) {
        this.isDsp = isDsp;
    }

    public boolean isDsp() {
        return this.isDsp;
    }
}
