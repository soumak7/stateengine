package com.search.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
    public class MetaDataResponse<T> {
        private Meta meta;
        private T data;

        public MetaDataResponse(Meta meta, T data) {
            this.meta = meta;
            this.data = data;
        }

        public static <T> MetaDataResponse.MetaDataResponseBuilder<T> builder() {
            return new MetaDataResponse.MetaDataResponseBuilder();
        }

        public Meta getMeta() {
            return this.meta;
        }

        public T getData() {
            return this.data;
        }

        public void setMeta(Meta meta) {
            this.meta = meta;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String toString() {
            return "MetaDataResponse(meta=" + this.getMeta() + ", data=" + this.getData() + ")";
        }

        public static class MetaDataResponseBuilder<T> {
            private Meta meta;
            private T data;

            MetaDataResponseBuilder() {
            }

            public MetaDataResponse.MetaDataResponseBuilder<T> meta(Meta meta) {
                this.meta = meta;
                return this;
            }

            public MetaDataResponse.MetaDataResponseBuilder<T> data(T data) {
                this.data = data;
                return this;
            }

            public MetaDataResponse<T> build() {
                return new MetaDataResponse(this.meta, this.data);
            }

            public String toString() {
                return "MetaDataResponse.MetaDataResponseBuilder(meta=" + this.meta + ", data=" + this.data + ")";
            }
        }
    }


