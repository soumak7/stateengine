package com.search.response;

public class CustomMetaException extends Exception {
        private MetaDataResponse metaDataResponse;

        public CustomMetaException(Throwable cause, MetaDataResponse metaDataResponse) {
            super(cause);
            this.metaDataResponse = metaDataResponse;
        }

        public CustomMetaException(MetaDataResponse metaDataResponse) {
            this.metaDataResponse = metaDataResponse;
        }

        public MetaDataResponse getMetaDataResponse() {
            return this.metaDataResponse;
        }

        public void setMetaDataResponse(MetaDataResponse metaDataResponse) {
            this.metaDataResponse = metaDataResponse;
        }

        public String toString() {
            return "CustomMetaException{metaDataResponse=" + this.metaDataResponse + '}';
        }
    }
