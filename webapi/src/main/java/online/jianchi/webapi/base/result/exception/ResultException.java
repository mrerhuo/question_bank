package online.jianchi.webapi.base.result.exception;

/***
 * 业务异常类
 * 
 * @author 二先生 @date：2020年01月20日
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

    public ResultException(final ResultStatus resultStatus) {
        super(resultStatus.getMessage());
        this.resultStatus = resultStatus;
    }

    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(final ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }
}
