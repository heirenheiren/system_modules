package org.system.toString;

import java.lang.reflect.Field;

public class BaseBean {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		try {
			Class<? extends BaseBean> t = this.getClass();
			 Field[] fields = t.getDeclaredFields();
	           for (int i = 0; i < fields.length; i++) {
	              Field field = fields[i];
	              field.setAccessible(true);
	              sb.append("{");
	              sb.append(field.getName());
	              sb.append(":");
	              if (field.getType() == int.class) {
	                  sb.append(field.getInt(this));
	              } else if (field.getType() == Integer.class) {
	                  sb.append(field.getInt(this));
	              } else if (field.getType() == Long.class) {
	                  sb.append(field.getLong(this));
	              } else if (field.getType() == Boolean.class) {
	                  sb.append(field.getBoolean(this));
	              } else if (field.getType() == char.class) {
	                  sb.append(field.getChar(this));
	              } else if (field.getType() == Double.class) {
	                  sb.append(field.getDouble(this));
	              } else if (field.getType() == Float.class) {
	                  sb.append(field.getFloat(this));
	              } else
	                  sb.append(field.get(this));
	              sb.append("}");
	           }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sb.toString();
	}
}
