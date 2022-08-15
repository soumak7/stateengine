package com.search.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Meta {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String status;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String requestId;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String code;

        public Meta(String status, String requestId, String code) {
            this.status = status;
            this.requestId = requestId;
            this.code = code;
        }

        public static Meta.MetaBuilder builder() {
            return new Meta.MetaBuilder();
        }

        public String getStatus() {
            return this.status;
        }

        public String getRequestId() {
            return this.requestId;
        }

        public String getCode() {
            return this.code;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String toString() {
            return "Meta(status=" + this.getStatus() + ", requestId=" + this.getRequestId() + ", code=" + this.getCode() + ")";
        }

        public static class MetaBuilder {
            private String status;
            private String requestId;
            private String code;

            MetaBuilder() {
            }

            public Meta.MetaBuilder status(String status) {
                this.status = status;
                return this;
            }

            public Meta.MetaBuilder requestId(String requestId) {
                this.requestId = requestId;
                return this;
            }

            public Meta.MetaBuilder code(String code) {
                this.code = code;
                return this;
            }

            public Meta build() {
                return new Meta(this.status, this.requestId, this.code);
            }

            public String toString() {
                return "Meta.MetaBuilder(status=" + this.status + ", requestId=" + this.requestId + ", code=" + this.code + ")";
            }
        }
    }
