package com.swallow.fly.utils

/**
 * @Description:
 * @Author:   Hsp
 * @Email:    1101121039@qq.com
 * @CreateTime:     2020/8/29 15:23
 * @UpdateRemark:   更新说明：
 */
class UrlEncoderUtils {
    companion object {
        /**
         * 判断 str 是否已经 URLEncoder.encode() 过
         * 经常遇到这样的情况, 拿到一个 URL, 但是搞不清楚到底要不要 URLEncoder.encode()
         * 不做 URLEncoder.encode() 吧, 担心出错, 做 URLEncoder.encode() 吧, 又怕重复了
         *
         * @param str 需要判断的内容
         * @return 返回 `true` 为被 URLEncoder.encode() 过
         */
        fun hasUrlEncoded(str: String): Boolean {
            var encode = false
            for (i in 0 until str.length) {
                val c = str[i]
                if (c == '%' && i + 2 < str.length) {
                    // 判断是否符合urlEncode规范
                    val c1 = str[i + 1]
                    val c2 = str[i + 2]
                    if (isValidHexChar(c1) && isValidHexChar(c2)) {
                        encode = true
                        break
                    } else {
                        break
                    }
                }
            }
            return encode
        }

        /**
         * 判断 c 是否是 16 进制的字符
         *
         * @param c 需要判断的字符
         * @return 返回 `true` 为 16 进制的字符
         */
        private fun isValidHexChar(c: Char): Boolean {
            return '0' <= c && c <= '9' || 'a' <= c && c <= 'f' || 'A' <= c && c <= 'F'
        }
    }
}