terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
  required_version = ">= 1.2.0"
}

provider "aws" {
    region     = "us-east-1"
}

resource "aws_s3_bucket" "chroma-raw-image-uploads" {
  bucket = "chroma-raw-image-uploads"
  tags = {
    Name        = "Chroma Uploads"
    Environment = "Production"
  }
}

