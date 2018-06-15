package com.dagemen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;


public class PointUserDO  {

    /**
     * 用户Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 员工编号
     */
    private String code;
    /**
     * 连锁品牌id
     */
    private Long chainId;
    /**
     * 连锁品牌名称
     */
    private String chainName;
    /**
     * 门店id
     */
    private Long pointId;
    /**
     * 门店名称
     */
    private String pointName;
    /**
     * 职位id
     */
    private Long positionId;
    /**
     * 职位名
     */
    private String positionName;
    /**
     * 真实名称
     */
    private String realName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 薪资
     */
    private BigDecimal salary;
    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.util.Date birthday;
    /**
     * 住址
     */
    private String address;
    /**
     * 密码
     */
    private String password;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 员工星级
     */
    private String star;
    /**
     * 减免额度
     */
    private Long remit;
    /**
     * 打折额度
     */
    private Integer discount;
    /**
     * 用户状态 1正常 ，2冻结，3注销
     */
    private Integer status;
    /**
     * 离职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date leaveDate;
    /**
     * 是否可登录
     */
    private Boolean login;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 银行编号
     */
    private Long bankId;
    /**
     * 银行名
     */
    private String bankName;
    /**
     * 银行卡号
     */
    private String bankCardNum;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建人id
     */
    private Long creatorId;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date createDate;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改人id
     */
    private Long modifierId;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private java.util.Date modifyDate;

    public PointUserDO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public BigDecimal getSalary() {
        return salary;
    }

    public PointUserDO setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public java.util.Date getBirthday() {
        return birthday;
    }

    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public Long getRemit() {
        return remit;
    }

    public void setRemit(Long remit) {
        this.remit = remit;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(java.util.Date leaveDate) {
        this.leaveDate = leaveDate;
    }


    public Boolean getLogin() {
        return login;
    }

    public PointUserDO setLogin(Boolean login) {
        this.login = login;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCardNum() {
        return bankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        this.bankCardNum = bankCardNum;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public java.util.Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(java.util.Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "PointUserDO{" +
                "id=" + id +
                ",code=" + code +
                ",chainId=" + chainId +
                ",chainName=" + chainName +
                ",pointId=" + pointId +
                ",pointName=" + pointName +
                ",positionId=" + positionId +
                ",positionName=" + positionName +
                ",realName=" + realName +
                ",nickName=" + nickName +
                ",avatar=" + avatar +
                ",phone=" + phone +
                ",salary=" + salary +
                ",birthday=" + birthday +
                ",address=" + address +
                ",password=" + password +
                ",idCard=" + idCard +
                ",star=" + star +
                ",remit=" + remit +
                ",discount=" + discount +
                ",status=" + status +
                ",leaveDate=" + leaveDate +
                ",login=" + login +
                ",remark=" + remark +
                ",bankId=" + bankId +
                ",bankName=" + bankName +
                ",bankCardNum=" + bankCardNum +
                ",creator=" + creator +
                ",creatorId=" + creatorId +
                ",createDate=" + createDate +
                ",modifier=" + modifier +
                ",modifierId=" + modifierId +
                ",modifyDate=" + modifyDate +
                '}';
    }
}
