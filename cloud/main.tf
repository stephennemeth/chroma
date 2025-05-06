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
resource "aws_ecs_cluster" "chroma-cluster" {
  name = "chroma-cluster"
  tags = {
    Name        = "Chroma Cluster"
    Environment = "Production"
  }
}
resource "aws_ecs_task_definition" "chroma-task" {
  family                   = "chroma-task"
  container_definitions = jsonencode([
    {
      name         = "chroma-backend"
      image        = "528757801517.dkr.ecr.us-east-1.amazonaws.com/chroma:latest"
      cpu          = 256
      memory       = 512
      essential    = true
      portMappings = [
        {
          containerPort = 8080
          hostPort      = 8080
          protocol      = "tcp"
        }
      ]
    }
  ])
}
resource "aws_ecs_service" "chroma-service" {
  name            = "chroma-service"
  cluster         = aws_ecs_cluster.chroma-cluster.id
  task_definition = aws_ecs_task_definition.chroma-task.id
  desired_count   = 1
  launch_type     = "FARGATE"
}
resource "aws_s3_bucket" "chroma-raw-image-uploads" {
  bucket = "chroma-raw-image-uploads"
  tags = {
    Name        = "Chroma Uploads"
    Environment = "Production"
  }
}

resource "aws_s3_bucket" "chroma-processed-image-uploads" {
  bucket = "chroma-processed-image-uploads"
  tags = {
    Name        = "Chroma Processed Uploads"
    Environment = "Production"
  }
}
