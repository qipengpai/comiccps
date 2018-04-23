package com.qpp.comiccps.basics.entity.data;

public class UserEntityData {

//	private String userId = "";
	private String openid = "";// 用户的标识，对当前公众号唯一
	private String subscribe = "";// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
	private String nickname = "";// 用户的昵称
	private String sex = "";// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private String city = "";// 用户所在城市
	private String country = "";// 用户所在国家
	private String province = "";// 用户所在省份
	private String language = "";// 用户的语言，简体中文为zh_CN
	private String headimgurl = "";// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
	private String headimgSize = "";// 用户头像大小
	private String subscribe_time = "";// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
	private String unionid = "";// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
	private String phone = ""; // 手机号
	private String username = ""; // 用户名
	private String userPassword = "";// 密码
	private String usercarid = "";
	private String integral = "";/* 货币 */
	private String vipId = "";
	private String platformIndex = ""; // 渠道
	private String registerDate;
	private String nowPage = ""; // 当前页
	private String pageNum = ""; // 每页容量
	private String condition = ""; // 查询条件
	private String code = ""; // 验证码
	private String hobby = "";// 土豪模式
	private String implDate = "";// 修改时间
	private String birthday = "";// 生日
	private String headPortrait = "";// 头像
	private String truePhone = "";// 绑定的手机号
	private String truePhoneDate = "";// 绑定的手机号時間
	private String deviceId = "";// 设备Id
	private String systemVersion = "";// 版本号
	private String appid = "";// 用户的标识，对当前公众号唯一
	
	
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}

	public String getTruePhone() {
		return truePhone;
	}

	public void setTruePhone(String truePhone) {
		this.truePhone = truePhone;
	}

	public String getTruePhoneDate() {
		return truePhoneDate;
	}

	public void setTruePhoneDate(String truePhoneDate) {
		this.truePhoneDate = truePhoneDate;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getImplDate() {
		return implDate;
	}

	public void setImplDate(String implDate) {
		this.implDate = implDate;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getHeadimgSize() {
		return headimgSize;
	}

	public void setHeadimgSize(String headimgSize) {
		this.headimgSize = headimgSize;
	}

	public String getSubscribe_time() {
		return subscribe_time;
	}

	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUsercarid() {
		return usercarid;
	}

	public void setUsercarid(String usercarid) {
		this.usercarid = usercarid;
	}

	public String getIntegral() {
		return integral;
	}

	public void setIntegral(String integral) {
		this.integral = integral;
	}

	public String getVipId() {
		return vipId;
	}

	public void setVipId(String vipId) {
		this.vipId = vipId;
	}

	public String getPlatformIndex() {
		return platformIndex;
	}

	public void setPlatformIndex(String platformIndex) {
		this.platformIndex = platformIndex;
	}

	public String getNowPage() {
		return nowPage;
	}

	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
}
