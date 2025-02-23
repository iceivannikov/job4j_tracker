package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplifyPathTest {

    @Test
    public void whenPathEndsWithSlashThenRemoveTrailingSlash() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home/");
        assertEquals("/home", result);
    }

    @Test
    public void whenPathHasMultipleSlashesThenReplaceWithSingleSlash() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home//foo/");
        assertEquals("/home/foo", result);
    }

    @Test
    public void whenPathHasParentDirectoryThenGoUpOneLevel() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home/user/Documents/../Pictures");
        assertEquals("/home/user/Pictures", result);
    }

    @Test
    public void whenPathGoesAboveRootThenReturnRoot() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/../");
        assertEquals("/", result);
    }

    @Test
    public void whenPathHasCurrentDirectoryThenIgnoreIt() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/home/./user/./Documents");
        assertEquals("/home/user/Documents", result);
    }

    @Test
    public void whenPathHasValidDotsThenTreatAsDirectory() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/.../a/../b/c/../d/./");
        assertEquals("/.../b/d", result);
    }

    @Test
    public void whenPathIsRootThenReturnRoot() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/");
        assertEquals("/", result);
    }

    @Test
    public void whenPathIsEmptyThenReturnRoot() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("");
        assertEquals("/", result);
    }

    @Test
    public void whenPathHasComplexStructureThenSimplifyCorrectly() {
        SimplifyPath simplifier = new SimplifyPath();
        String result = simplifier.simplify("/a/b/../../c/");
        assertEquals("/c", result);
    }
}