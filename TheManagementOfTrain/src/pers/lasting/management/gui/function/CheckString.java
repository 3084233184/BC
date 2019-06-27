package pers.lasting.management.gui.function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class CheckString {
	public static boolean isHaveSpace(String str0) {
		// TODO Auto-generated method stub
		String str1 = str0.trim();
		if(!str1.equals(str0))
			return true;
		else 
			return false;
	}
	
	public static boolean isHaveChar(String str0) {
		char [] charArray = str0.toCharArray();
		for(char s :charArray) {
			if(s>='a' && s<='z')
				return true;
		}
		return false;
	}
	
	public static boolean isHaveNumber(String str0) {
		char [] charArray = str0.toCharArray();
		for(char s :charArray) {
			if(s>='0' && s<='9')
				return true;
		}
		return false;
	}

	public static void textTrim(JTextField userText) {
		// TODO Auto-generated method stub
		if(isHaveSpace(userText.getText()))
			userText.setText(userText.getText().trim());
	}
	
	public static boolean isOnlyNumber(String str0) {
		
		char [] charArray = str0.toCharArray();
		for(char s :charArray) {
			if(s<'0' || s>'9') 
				return false;
		}
		return true;
	}
	
	
	public static boolean isChinese(String str0) {
			String regex = "[\u4E00-\u9FA5]+";
			if(str0.matches(regex))
				return true;
			else
			return false;
	}
	

	    /**
	     * �ж��ַ������Ƿ��������
	     * @param str
	     * ��У���ַ���
	     * @return �Ƿ�Ϊ����
	     * @warn ����У���Ƿ�Ϊ���ı�����
	     */
	    public static boolean isContainChinese(String str) {
	        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
	        Matcher m = p.matcher(str);
	        if (m.find()) {
	            return true;
	        }
	        return false;
	    }

	    /**
	     * ���˵�����
	     * @param str ���������ĵ��ַ���
	     * @return ���˵����ĺ��ַ���
	     */
	    public static String filterChinese(String str) {
	        // ���ڷ��ؽ��
	        String result = str;
	        boolean flag = isContainChinese(str);
	        if (flag) {// ��������
	            // ����ƴ�ӹ������ĺ���ַ�
	            StringBuffer sb = new StringBuffer();
	            // ����У���Ƿ�Ϊ����
	            boolean flag2 = false;
	            // ������ʱ�洢���ַ�
	            char chinese = 0;
	            // 5.ȥ�����ļ����е�����
	            // ���ַ���ת����char[]
	            char[] charArray = str.toCharArray();
	            // ���˵����ļ������ַ�
	            for (int i = 0; i < charArray.length; i++) {
	                chinese = charArray[i];
	                flag2 = isChinese(chinese);
	                if (!flag2) {// �������պ����ּ�������
	                    sb.append(chinese);
	                }
	            }
	            result = sb.toString();
	        }
	        return result;
	    }


	    /**
	     * У��һ���ַ��Ƿ��Ǻ���
	     *
	     * @param c
	     *  ��У����ַ�
	     * @return true�����Ǻ���
	     */
	    public static boolean isChineseChar(char c) {
	        try {
	            return String.valueOf(c).getBytes("UTF-8").length > 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    /**
	     * ��֤�ַ��������Ƿ�������зǷ��ַ�<br>
	     * `~!#%^&*=+\\|{};:'\",<>/?����������p�Ωe
	     *
	     * @param content
	     *  �ַ�������
	     * @return 't'���������Ƿ��ַ���otherwise��������Ƿ��ַ���
	     */
	    public static char validateLegalString(String content) {
	        String illegal = "`~!#%^&*=+\\|{};:'\",<>/?����������p�Ωe";
	        char isLegalChar = 't';
	        L1: for (int i = 0; i < content.length(); i++) {
	            for (int j = 0; j < illegal.length(); j++) {
	                if (content.charAt(i) == illegal.charAt(j)) {
	                    isLegalChar = content.charAt(i);
	                    break L1;
	                }
	            }
	        }
	        return isLegalChar;
	    }

	    /**
	     * ��֤�Ƿ��Ǻ��ֻ���0-9��a-z��A-Z
	     *
	     * @param c
	     *  ����֤��char
	     * @return true�����������
	     */
	    public static boolean isRightChar(char c) {
	        return isChinese(c) || isWord(c);
	    }
	    
	    /**
	     * У��һ���ַ����Ƿ�Ϊa-z��A-Z��_��0-9
	     * @param c
	     * ��У����ַ���
	     * @return true��ʾ��������
	     */
	    public static boolean isRightPassWord(String str0) {
	    	char [] charArrays = str0.toCharArray();
	    	for(char ch : charArrays)
	    		if(!isRightChar(ch))
	    			return false;
	    	return true;
	    }
	    /**
	     * У��ĳ���ַ��Ƿ���a-z��A-Z��_��0-9
	     *
	     * @param c
	     *  ��У����ַ�
	     * @return true�����������
	     */
	    public static boolean isWord(char c) {
	        String regEx = "[\\w]";
	        Pattern p = Pattern.compile(regEx);
	        Matcher m = p.matcher("" + c);
	        return m.matches();
	    }

	    /**
	     * �ж�������Ƿ��Ǻ���
	     *
	     * @param c
	     *  ��У����ַ�
	     * @return true�����Ǻ���
	     */
	    public static boolean isChinese(char c) {
	        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
	        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
	                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
	                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
	                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
	                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
	                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
	            return true;
	        }
	        return false;
	    }

	    /**
	     * У��String�Ƿ�ȫ������
	     *
	     * @param name
	     *  ��У����ַ���
	     * @return true����ȫ�Ǻ���
	     */
	    public static boolean checkNameChese(String name) {
	        boolean res = true;
	        char[] cTemp = name.toCharArray();
	        for (int i = 0; i < name.length(); i++) {
	            if (!isChinese(cTemp[i])) {
	                res = false;
	                break;
	            }
	        }
	        return res;
	    }
}
