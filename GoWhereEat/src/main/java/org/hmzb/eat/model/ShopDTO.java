/**
 * 
 */
package org.hmzb.eat.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ������.
 * 
 * @author zhufu
 * 
 *         <pre>
 * �޸�����		�޸���	�޸�ԭ��
 * 2012-6-18	zhufu	�½�
 * </pre>
 */
public class ShopDTO implements Parcelable {

    /**
     * ����.
     */
    private int _id;
    /**
     * ��������.
     */
    private String name;
    /**
     * ���̵�ַ.
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
        dest.writeInt(getId());
        dest.writeString(getName());
        dest.writeString(getAddress());
    }

    /**
     * �����л�������.
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
     * �����л����캯��.
     * 
     * @param in
     */
    private ShopDTO(Parcel in) {
        setId(in.readInt());
        name = in.readString();
        address = in.readString();
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }
}
