package online.jianchi.webapi.base.result.exception;

/**
 * 业务异常类
 *
 * @author galaxy
 * @date 2019/10/05 16:19
 */
public class ResultException extends Exception {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ResultStatus resultStatus;

    public ResultException() {
        this(ResultStatus.INTERNAL_SERVER_ERROR);
    }

    public ResultException(ResultStatus resultStatus) {
        super(resultStatus.getMessage());
        this.resultStatus = resultStatus;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
