/**
 * 
 */
package org.hmzb.eat.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 【】类.
 * 
 * @author zhufu
 * 
 *         <pre>
 * 修改日期		修改人	修改原因
 * 2012-6-18	zhufu	新建
 * </pre>
 */
public class ShopDTO implements Parcelable {

    private int _id;
    /**
     * 商铺名称.
     */
    private String name;
    /**
     * 商铺地址.
     */
    private String address;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(getName());
        dest.writeString(getAddress());
    }

    /**
     * 反序列化构造器.
     */
    public static final Parcelable.Creator<ShopDTO> CREATOR = new Parcelable.Creator<ShopDTO>() {

        /*
         * (non-Javadoc)
         * 
         * @see android.os.Parcelable.Creator#createFromParcel(android.os.Parcel)
         */
        @Override
        public ShopDTO createFromParcel(Parcel source) {
            return new ShopDTO(source);
        }

        /*
         * (non-Javadoc)
         * 
         * @see android.os.Parcelable.Creator#newArray(int)
         */
        @Override
        public ShopDTO[] newArray(int size) {
            return new ShopDTO[size];
        }

    };

    public ShopDTO() {

    }
    
    public ShopDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * 反序列化构造函数.
     * 
     * @param in
     */
    private ShopDTO(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        address = in.readString();
    }
}
