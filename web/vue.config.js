module.exports = {
	css: { // 配置css模块
		loaderOptions: {
			sass: {
				prependData: `@import "~@/style/variable.scss";`
			}
		}
	}
}