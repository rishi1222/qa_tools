package cat.config;


import cat.page.*;


/**
 * Created by kaporis on 19/02/2018.
 */
public class Pages extends AbstractPage{
    private LoginPage loginPage;
    private SegmentCreationPage segmentCreationPage;
    private ResetCaseState resetCaseState;
    private IRGMCloseAction irgmCloseAction;
    private IRGACloseAction irgaCloseAction;
    private FosSegmentReviewAction fosSegmentReviewAction;
    private CaseReviewAction caseReviewAction;
    private FoSUpgradeAction fosUpgradeAction;
    private MoSegmentReviewAction moSegmentReviewAction;
    private IRGCaseReviewAction irgCaseReviewAction;


    public Pages() {

    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public SegmentCreationPage segmentCreationPage() {
        if (segmentCreationPage == null) {
            segmentCreationPage = new SegmentCreationPage();
        }
        return segmentCreationPage;
    }


    public ResetCaseState resetCaseState() {
        if (resetCaseState == null) {
            resetCaseState = new ResetCaseState();
        }
        return resetCaseState;
    }

    public IRGMCloseAction irgmCloseAction() {
        if (irgmCloseAction == null) {
            irgmCloseAction = new IRGMCloseAction();
        }
        return irgmCloseAction;
    }

    public IRGACloseAction irgaCloseAction() {
        if (irgaCloseAction == null) {
            irgaCloseAction = new IRGACloseAction();
        }
        return irgaCloseAction;
    }


    public FosSegmentReviewAction fosSegmentReviewAction() {
        if (fosSegmentReviewAction == null) {
            fosSegmentReviewAction = new FosSegmentReviewAction();
        }
        return fosSegmentReviewAction;
    }

    public CaseReviewAction caseReviewAction() {
        if (caseReviewAction == null) {
            caseReviewAction = new CaseReviewAction();
        }
        return caseReviewAction;
    }

    public FoSUpgradeAction fosUpgradeAction() {
        if (fosUpgradeAction == null) {
            fosUpgradeAction = new FoSUpgradeAction();
        }
        return fosUpgradeAction;
    }

    public MoSegmentReviewAction moSegmentReviewAction() {
        if (moSegmentReviewAction == null) {
            moSegmentReviewAction = new MoSegmentReviewAction();
        }
        return moSegmentReviewAction;
    }


    public IRGCaseReviewAction irgCaseReviewAction() {

        if (irgCaseReviewAction == null) {
            irgCaseReviewAction = new IRGCaseReviewAction();
        }
        return irgCaseReviewAction;
    }
}
