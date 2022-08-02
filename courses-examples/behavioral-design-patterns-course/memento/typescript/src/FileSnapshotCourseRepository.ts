import fs from "fs";

import { CourseSnapshot } from "./CourseSnapshot";

export class FileSnapshotCourseRepository {
  findLastSnapshot(id: string): CourseSnapshot {
    // TODO: Optimize reads
    const snapshots = fs
      .readFileSync(`snapshots-${id}.txt`, { flag: "r" })
      .toString()
      .trim()
      .split("\n")
      .map((e) => JSON.parse(e));

    return snapshots[snapshots.length - 1];
  }

  save(courseSnapshot: CourseSnapshot): void {
    fs.writeFileSync(
      `snapshots-${courseSnapshot.id}.txt`,
      JSON.stringify(courseSnapshot) + "\n",
      { flag: "a" }
    );
  }

  remove(id: string): void {
    const path = `snapshots-${id}.txt`;
    if (fs.existsSync(path)) {
      fs.unlinkSync(path);
    }
  }
}
