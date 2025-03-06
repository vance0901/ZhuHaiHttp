package com.vance0901.zhuhai.network.http.config;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * HTTP配置类 HTTP configuration class
 */
public class HttpConfig {
    private String baseUrl;
    private long connectTimeout;
    private long readTimeout;
    private long writeTimeout;
    private boolean debug;
    private HttpLoggingInterceptor.Level logLevel;

    private HttpConfig(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.writeTimeout = builder.writeTimeout;
        this.debug = builder.debug;
        this.logLevel = builder.logLevel;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public boolean isDebug() {
        return debug;
    }

    public HttpLoggingInterceptor.Level getLogLevel() {
        return logLevel;
    }

    public static class Builder {
        private String baseUrl;
        private long connectTimeout = 10000;
        private long readTimeout = 10000;
        private long writeTimeout = 10000;
        private boolean debug = false;
        private HttpLoggingInterceptor.Level logLevel = HttpLoggingInterceptor.Level.NONE;

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder connectTimeout(long timeout) {
            this.connectTimeout = timeout;
            return this;
        }

        public Builder readTimeout(long timeout) {
            this.readTimeout = timeout;
            return this;
        }

        public Builder writeTimeout(long timeout) {
            this.writeTimeout = timeout;
            return this;
        }

        public Builder debug(boolean debug) {
            this.debug = debug;
            return this;
        }

        public Builder logLevel(HttpLoggingInterceptor.Level level) {
            this.logLevel = level;
            return this;
        }

        public HttpConfig build() {
            if (baseUrl == null || baseUrl.isEmpty()) {
                throw new IllegalStateException("The Base Url cannot be null or empty");
            }
            return new HttpConfig(this);
        }
    }
} 